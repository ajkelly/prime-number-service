
// Generated by Akka gRPC. DO NOT EDIT.
package primenumberserver.grpc

import scala.concurrent.ExecutionContext

import akka.grpc.scaladsl.{ GrpcExceptionHandler, GrpcMarshalling }
import akka.grpc.Trailers

import akka.actor.ActorSystem
import akka.actor.ClassicActorSystemProvider
import akka.annotation.ApiMayChange
import akka.http.scaladsl.model
import akka.stream.SystemMaterializer

import akka.grpc.internal.TelemetryExtension




/*
 * Generated by Akka gRPC. DO NOT EDIT.
 *
 * The API of this class may still change in future Akka gRPC versions, see for instance
 * https://github.com/akka/akka-grpc/issues/994
 */
@ApiMayChange
object PrimeNumberHandler {
    private val notFound = scala.concurrent.Future.successful(model.HttpResponse(model.StatusCodes.NotFound))
    private val unsupportedMediaType = scala.concurrent.Future.successful(model.HttpResponse(model.StatusCodes.UnsupportedMediaType))

    /**
     * Creates a `HttpRequest` to `HttpResponse` handler that can be used in for example `Http().bindAndHandleAsync`
     * for the generated partial function handler and ends with `StatusCodes.NotFound` if the request is not matching.
     *
     * Use `akka.grpc.scaladsl.ServiceHandler.concatOrNotFound` with `PrimeNumberHandler.partial` when combining
     * several services.
     */
    def apply(implementation: PrimeNumber)(implicit system: ClassicActorSystemProvider): model.HttpRequest => scala.concurrent.Future[model.HttpResponse] =
      partial(implementation).orElse { case _ => notFound }

    /**
     * Creates a `HttpRequest` to `HttpResponse` handler that can be used in for example `Http().bindAndHandleAsync`
     * for the generated partial function handler and ends with `StatusCodes.NotFound` if the request is not matching.
     *
     * Use `akka.grpc.scaladsl.ServiceHandler.concatOrNotFound` with `PrimeNumberHandler.partial` when combining
     * several services.
     */
    def apply(implementation: PrimeNumber, eHandler: ActorSystem => PartialFunction[Throwable, Trailers])(implicit system: ClassicActorSystemProvider): model.HttpRequest => scala.concurrent.Future[model.HttpResponse] =
      partial(implementation, PrimeNumber.name, eHandler).orElse { case _ => notFound }

    /**
     * Creates a `HttpRequest` to `HttpResponse` handler that can be used in for example `Http().bindAndHandleAsync`
     * for the generated partial function handler and ends with `StatusCodes.NotFound` if the request is not matching.
     *
     * Use `akka.grpc.scaladsl.ServiceHandler.concatOrNotFound` with `PrimeNumberHandler.partial` when combining
     * several services.
     *
     * Registering a gRPC service under a custom prefix is not widely supported and strongly discouraged by the specification.
     */
    def apply(implementation: PrimeNumber, prefix: String)(implicit system: ClassicActorSystemProvider): model.HttpRequest => scala.concurrent.Future[model.HttpResponse] =
      partial(implementation, prefix).orElse { case _ => notFound }

    /**
     * Creates a `HttpRequest` to `HttpResponse` handler that can be used in for example `Http().bindAndHandleAsync`
     * for the generated partial function handler and ends with `StatusCodes.NotFound` if the request is not matching.
     *
     * Use `akka.grpc.scaladsl.ServiceHandler.concatOrNotFound` with `PrimeNumberHandler.partial` when combining
     * several services.
     *
     * Registering a gRPC service under a custom prefix is not widely supported and strongly discouraged by the specification.
     */
    def apply(implementation: PrimeNumber, prefix: String, eHandler: ActorSystem => PartialFunction[Throwable, Trailers])(implicit system: ClassicActorSystemProvider): model.HttpRequest => scala.concurrent.Future[model.HttpResponse] =
      partial(implementation, prefix, eHandler).orElse { case _ => notFound }



    /**
     * Creates a `HttpRequest` to `HttpResponse` handler that can be used in for example `Http().bindAndHandleAsync`
     * for the generated partial function handler. The generated handler falls back to a reflection handler for
     * `PrimeNumber` and ends with `StatusCodes.NotFound` if the request is not matching.
     *
     * Use `akka.grpc.scaladsl.ServiceHandler.concatOrNotFound` with `PrimeNumberHandler.partial` when combining
     * several services.
     */
    def withServerReflection(implementation: PrimeNumber)(implicit system: ClassicActorSystemProvider): model.HttpRequest => scala.concurrent.Future[model.HttpResponse] =
        akka.grpc.scaladsl.ServiceHandler.concatOrNotFound(
          PrimeNumberHandler.partial(implementation),
          akka.grpc.scaladsl.ServerReflection.partial(List(PrimeNumber)))


    /**
     * Creates a partial `HttpRequest` to `HttpResponse` handler that can be combined with handlers of other
     * services with `akka.grpc.scaladsl.ServiceHandler.concatOrNotFound` and then used in for example
     * `Http().bindAndHandleAsync`.
     *
     * Use `PrimeNumberHandler.apply` if the server is only handling one service.
     *
     * Registering a gRPC service under a custom prefix is not widely supported and strongly discouraged by the specification.
     */
    def partial(implementation: PrimeNumber, prefix: String = PrimeNumber.name, eHandler: ActorSystem => PartialFunction[Throwable, Trailers] = GrpcExceptionHandler.defaultMapper)(implicit system: ClassicActorSystemProvider): PartialFunction[model.HttpRequest, scala.concurrent.Future[model.HttpResponse]] = {
      implicit val mat = SystemMaterializer(system).materializer
      implicit val ec: ExecutionContext = mat.executionContext
      val spi = TelemetryExtension(system).spi

      import PrimeNumber.Serializers._

      def handle(request: model.HttpRequest, method: String): scala.concurrent.Future[model.HttpResponse] =
        GrpcMarshalling.negotiated(request, (reader, writer) =>
          (method match {
            
            case "ListPrimeNumbers" =>
                
                GrpcMarshalling.unmarshal(request.entity.dataBytes)(PrimeNumberRequestSerializer, mat, reader)
                  .flatMap(implementation.listPrimeNumbers(_))
                  .map(e => GrpcMarshalling.marshal(e, eHandler)(PrimeNumberResponseSerializer, writer, system))
            
            case m => scala.concurrent.Future.failed(new NotImplementedError(s"Not implemented: $m"))
          })
          .recoverWith(GrpcExceptionHandler.from(eHandler(system.classicSystem))(system, writer))
      ).getOrElse(unsupportedMediaType)

      Function.unlift((req: model.HttpRequest) => req.uri.path match {
        case model.Uri.Path.Slash(model.Uri.Path.Segment(`prefix`, model.Uri.Path.Slash(model.Uri.Path.Segment(method, model.Uri.Path.Empty)))) =>
          Some(handle(spi.onRequest(prefix, method, req), method))
        case _ =>
          None
      })
    }
  }
