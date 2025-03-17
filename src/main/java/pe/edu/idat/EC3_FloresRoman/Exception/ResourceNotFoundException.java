package pe.edu.idat.EC3_FloresRoman.Exception;

public class ResourceNotFoundException
        extends RuntimeException {

    public ResourceNotFoundException(
            String message){
        super(message);
    }
}
