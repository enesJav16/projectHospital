package generateId;

public class GenerateId {
    private static Long hospitalId=0L;
    public static Long hospitalId(){
        return ++hospitalId;
    }

    private static Long departmentId=0L;
    public static Long departmentId(){
        return ++departmentId;
    }

    private static Long doctorId=0L;
    public static Long doctorId(){
        return ++doctorId;
    }

    private static Long patientId=0L;
    public static Long patientId(){
        return ++patientId;
    }
}
