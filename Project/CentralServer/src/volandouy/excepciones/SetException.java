package volandouy.excepciones;
import java.util.Set;

public class SetException extends Exception {
    private final Set<String> errorSet;

    public SetException(Set<String> errorSet) {
        super("Errores en la operación.");
        this.errorSet = errorSet;
    }

    public Set<String> getErrorSet() {
        return errorSet;
    }
}