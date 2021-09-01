// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package primenumberserver.grpc

@SerialVersionUID(0L)
final case class PrimeNumberResponse(
    primeNumbers: _root_.scala.Seq[_root_.scala.Int] = _root_.scala.Seq.empty,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[PrimeNumberResponse] {
    private[this] def primeNumbersSerializedSize = {
      if (__primeNumbersSerializedSizeField == 0) __primeNumbersSerializedSizeField = {
        var __s: _root_.scala.Int = 0
        primeNumbers.foreach(__i => __s += _root_.com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(__i))
        __s
      }
      __primeNumbersSerializedSizeField
    }
    @transient private[this] var __primeNumbersSerializedSizeField: _root_.scala.Int = 0
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      if (primeNumbers.nonEmpty) {
        val __localsize = primeNumbersSerializedSize
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__localsize) + __localsize
      }
      __size += unknownFields.serializedSize
      __size
    }
    override def serializedSize: _root_.scala.Int = {
      var read = __serializedSizeCachedValue
      if (read == 0) {
        read = __computeSerializedValue()
        __serializedSizeCachedValue = read
      }
      read
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
      if (primeNumbers.nonEmpty) {
        _output__.writeTag(1, 2)
        _output__.writeUInt32NoTag(primeNumbersSerializedSize)
        primeNumbers.foreach(_output__.writeInt32NoTag)
      };
      unknownFields.writeTo(_output__)
    }
    def clearPrimeNumbers = copy(primeNumbers = _root_.scala.Seq.empty)
    def addPrimeNumbers(__vs: _root_.scala.Int*): PrimeNumberResponse = addAllPrimeNumbers(__vs)
    def addAllPrimeNumbers(__vs: Iterable[_root_.scala.Int]): PrimeNumberResponse = copy(primeNumbers = primeNumbers ++ __vs)
    def withPrimeNumbers(__v: _root_.scala.Seq[_root_.scala.Int]): PrimeNumberResponse = copy(primeNumbers = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => primeNumbers
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PRepeated(primeNumbers.iterator.map(_root_.scalapb.descriptors.PInt(_)).toVector)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = primenumberserver.grpc.PrimeNumberResponse
    // @@protoc_insertion_point(GeneratedMessage[protobuf.PrimeNumberResponse])
}

object PrimeNumberResponse extends scalapb.GeneratedMessageCompanion[primenumberserver.grpc.PrimeNumberResponse] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[primenumberserver.grpc.PrimeNumberResponse] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): primenumberserver.grpc.PrimeNumberResponse = {
    val __primeNumbers: _root_.scala.collection.immutable.VectorBuilder[_root_.scala.Int] = new _root_.scala.collection.immutable.VectorBuilder[_root_.scala.Int]
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 8 =>
          __primeNumbers += _input__.readInt32()
        case 10 => {
          val length = _input__.readRawVarint32()
          val oldLimit = _input__.pushLimit(length)
          while (_input__.getBytesUntilLimit > 0) {
            __primeNumbers += _input__.readInt32()
          }
          _input__.popLimit(oldLimit)
        }
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    primenumberserver.grpc.PrimeNumberResponse(
        primeNumbers = __primeNumbers.result(),
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[primenumberserver.grpc.PrimeNumberResponse] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      primenumberserver.grpc.PrimeNumberResponse(
        primeNumbers = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Seq[_root_.scala.Int]]).getOrElse(_root_.scala.Seq.empty)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = PrimeNumberProto.javaDescriptor.getMessageTypes().get(1)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = PrimeNumberProto.scalaDescriptor.messages(1)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = primenumberserver.grpc.PrimeNumberResponse(
    primeNumbers = _root_.scala.Seq.empty
  )
  implicit class PrimeNumberResponseLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, primenumberserver.grpc.PrimeNumberResponse]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, primenumberserver.grpc.PrimeNumberResponse](_l) {
    def primeNumbers: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Seq[_root_.scala.Int]] = field(_.primeNumbers)((c_, f_) => c_.copy(primeNumbers = f_))
  }
  final val PRIME_NUMBERS_FIELD_NUMBER = 1
  def of(
    primeNumbers: _root_.scala.Seq[_root_.scala.Int]
  ): _root_.primenumberserver.grpc.PrimeNumberResponse = _root_.primenumberserver.grpc.PrimeNumberResponse(
    primeNumbers
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[protobuf.PrimeNumberResponse])
}
