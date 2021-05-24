package main;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Rank implements Serializable {
    private static final Map<Integer, String> allRanks = new HashMap<>();
    static {
        allRanks.put(1, "Szeregowy");
        allRanks.put(2, "Kapral");
        allRanks.put(3, "Kapitan");
        allRanks.put(4, "Major");
    }
    private String rank;
    private Integer value;

    public Rank(Integer rank) throws Exception {
        if (!allRanks.containsKey(rank)) {
            throw new Exception("The given rank does not exist!");
        }

        this.rank = allRanks.get(rank);
        this.value = rank;
    }

    public String rank() {
        return this.rank;
    }

    public Integer value() {
        return this.value;
    }

    public void update() {
        if (!this.value.equals(Collections.max(allRanks.keySet()))) {
            this.rank = allRanks.get(this.value + 1);
            this.value += 1;
        }
    }
}
