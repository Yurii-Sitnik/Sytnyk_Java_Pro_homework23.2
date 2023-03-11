public class FileMaxSizeReachedException extends RuntimeException {
            String string;

        public FileMaxSizeReachedException(String str) {
            this.string = str;
        }
        @Override
        public String getMessage() {
            return this.string;
        }
    }


