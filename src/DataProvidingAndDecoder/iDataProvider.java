package DataProvidingAndDecoder;



public interface iDataProvider {
    public byte[] fetchData(String urlAdress) throws Exception;
}
