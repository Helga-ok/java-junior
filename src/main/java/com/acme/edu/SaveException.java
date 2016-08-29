package com.acme.edu;

class SaveException extends Exception {
    SaveException() {
        super();
    }

    SaveException(String message) {
        super(message);
    }

    SaveException(String message, Throwable cause) {
        super(message, cause);
    }

    SaveException(Throwable cause) {
        super(cause);
    }

    SaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
