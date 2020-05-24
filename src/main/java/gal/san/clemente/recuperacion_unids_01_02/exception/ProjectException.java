package gal.san.clemente.recuperacion_unids_01_02.exception;

public class ProjectException extends Exception {
    
    public ProjectException(String message) {
        super(message);
    }

    public ProjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectException(Throwable cause) {
        super(cause);
    }
}