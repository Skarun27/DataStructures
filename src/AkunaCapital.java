import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AkunaCapital {

    public static class HashTable {
        Map<String, String> eventTable;
        public HashTable(ArrayList<String> rawEvents) {
            this.eventTable = new HashMap();
            for(String events: rawEvents)
            eventTable.put(events.split("|")[2], events.split("|")[3]);
        }

        public Map<String, String> getTable() {
            return null;
        }

        public Instant getHighWaterMark() {
            return null;
        }
    }
}
