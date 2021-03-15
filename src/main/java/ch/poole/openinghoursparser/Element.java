package ch.poole.openinghoursparser;

/**
 * Force implementation of equals and hashcode
 * 
 * @author Simon Poole
 *
 */
abstract class Element implements Copy<Element> {
    // put other methods from interface here

    @Override
    public abstract boolean equals(Object other);

    @Override
    public abstract int hashCode();

    /**
     * Create a string that identifies which class created it for debugging and testing
     * 
     * @return the output of toString with the class name prepended
     */
    public String toDebugString() {
        return getClass().getSimpleName() + ":" + toString();
    }
}
