package edu.lemon.database.exception;

public class ConnectionException extends Exception {

  private static final String DEFAULT_EXCEPTION_MESSAGE = "Connection was not established";
  /**
   * Constructs a new runtime exception with {@code null} as its
   * detail message.  The cause is not initialized, and may subsequently be
   * initialized by a call to {@link #initCause}.
   */
  public ConnectionException() {
    super(DEFAULT_EXCEPTION_MESSAGE);
  }

  /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ConnectionException(String message) {
        super(message);
    }
}
