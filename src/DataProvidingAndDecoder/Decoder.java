package DataProvidingAndDecoder;

public class Decoder implements iDecoder{
    @Override
    public String decode(byte[] data) {
        return new String(data);
    }
}
