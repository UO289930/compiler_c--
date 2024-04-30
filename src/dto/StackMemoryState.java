package dto;

public class StackMemoryState {

    private final int bytesReturn;
    private final int bytesLocals;
    private final int bytesArgs;

    public StackMemoryState(int bytesReturn, int bytesLocals, int bytesArgs) {
        this.bytesReturn = bytesReturn;
        this.bytesLocals = bytesLocals;
        this.bytesArgs = bytesArgs;
    }

    public int getBytesReturn() {
        return bytesReturn;
    }

    public int getBytesLocals() {
        return bytesLocals;
    }

    public int getBytesArgs() {
        return bytesArgs;
    }
}
