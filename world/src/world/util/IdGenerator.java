package world.util;

public class IdGenerator {
    private static int StationId = 0;
    private static int LineId = 0;

    public static int createStationId(){
        return ++StationId;
    }

    public static int createLineId(){
        return ++LineId;
    }

    public static String getCurrentStringStationId() {
        return ""+StationId;
    }

    public static String getCurrentStringLineId() {
        return ""+LineId;
    }

    public static void resetCounts(){
        LineId = 0;
        StationId = 0;
    }
}
