package pl.bartoszkaczmarczyk.plantnurserymanagement.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(Class<?> entity) {
        super(entity.getSimpleName() + " not found.");
    }

    public EntityNotFoundException(Class<?> entity, Long id) {
        super(entity.getSimpleName() + " id: " + id + " not found.");
    }

    public EntityNotFoundException(Class<?> entity1, Class<?> entity2, Long id1, Long id2) {
        super(entity1.getSimpleName() + " id: " + id1 + " not found or "
        + entity2.getSimpleName() + " id: " + id2 + " not found.");
    }

}
