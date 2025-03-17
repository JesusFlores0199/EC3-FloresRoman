package pe.edu.idat.EC3_FloresRoman.Exception;

import java.util.Date;

public class ErrorMenssage {
    private Integer statusCode;
    private Date dateError;
    private String message;
    private String description;

    public Integer getStatusCode() {
        return statusCode;
    }

    public Date getDateError() {
        return dateError;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public ErrorMenssage(Integer statusCode, Date dateError, String message, String description) {
        this.statusCode = statusCode;
        this.dateError = dateError;
        this.message = message;
        this.description = description;
    }
}