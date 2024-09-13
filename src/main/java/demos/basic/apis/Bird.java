package demos.basic.apis;

public record Bird(String englishName,
                   double wingSpan,
                   int maximumAge) implements Comparable<Bird> {
    @Override
    public int compareTo(Bird o) {
        return 0;
    }
}



//    @Override
//    public int compareTo(Bird other) {
//        //declare named variables for readability
//        final int BEFORE = -1;
//        final int EQUAL = 0;
//        final int AFTER = 1;
//        //compare
//        if(this.wingSpan <= other.wingSpan) return BEFORE;
//        else if (this.wingSpan >= other.wingSpan) return AFTER;
//        else return EQUAL;
//    }





//    @Override
//    public int compareTo(Bird other) {
//        final int compareWingSpan = Double.compare(this.wingSpan, other.wingSpan);
//        if (compareWingSpan == 0) {
//            return this.englishName.compareTo(other.englishName);
//        }
//        return compareWingSpan;
//
//    }
