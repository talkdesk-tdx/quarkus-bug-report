package tck.utils;

import javax.enterprise.context.ApplicationScoped;
import org.example.errorhandling.ErrorCode;
import utils.ReferenceErrorCode;

@ApplicationScoped
public class ReferenceErrorCodeProvider implements ReferenceErrorCode {
    @Override
    public ErrorCode getNegativePageIndexErrorCode() {
        return new ErrorCode() {
            @Override
            public String getCode() {
                return "";
            }
        };
    }

    @Override
    public ErrorCode getNegativePerPageErrorCode() {
        return new ErrorCode() {
            @Override
            public String getCode() {
                return "";
            }
        };
    }
}
