package utils;


import org.example.errorhandling.ErrorCode;

/**
 * Define the error contract.
 */
public interface ReferenceErrorCode {

    ErrorCode getNegativePageIndexErrorCode();

    ErrorCode getNegativePerPageErrorCode();
}
