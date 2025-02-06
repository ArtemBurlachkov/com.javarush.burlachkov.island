package configuration;


public enum BiologicalType {
    WOLF
            (50d, 30, 3, 8d, "\uD83D\uDC3A"),
    BOA_CONSTRICTOR
            (15d, 30,1, 3d, "\uD83D\uDC0D"),
    FOX
            (8d, 30,2, 2d,"\uD83E\uDD8A"),
    BEAR
            (500d, 5,2, 80d, "\uD83D\uDC3B"),
    EAGLE
            (6d, 20,3, 1d, "\uD83E\uDD85"),
    HORSE
            (400d, 20,4, 60d,"\uD83D\uDC0E"),
    DEER
            (300d, 20,4, 50d, "\uD83D\uDC11"),
    RABBIT
            (2d, 150,2, 0.45d, "\uD83D\uDC07"),
    MOUSE
            (0.05d, 500,1, 0.01d, "\uD83D\uDC01"),
    GOAT
            (60d, 140,3, 10d,"\uD83D\uDC10"),
    SHEEP
            (70d, 140,3, 15d, "\uD83D\uDC11"),
    WILD_BOARD
            (400d, 50,2, 50d, "\uD83D\uDC17"),
    BUFFALO
            (700d, 10,3, 100d, "\uD83D\uDC03"),
    DUCK
            (1d, 200,4, 0.15d,"\uD83E\uDD86"),
    CATERPILLAR
            (0.01d, 1000,0, 0d, "\uD83D\uDC1B"),
    PLANT
            (1d, 200,0, 0d, "\uD83C\uDF3F");

    private Double maxWeight, maximumSaturation ;
    private Integer maxValueOnLocation, maxMovementSpeed;
    private String icon;

    BiologicalType(Double maxWeight, Integer maxValueOnLocation, Integer maxMovementSpeed, Double maximumSaturation, String icon) {
        this.maxWeight = maxWeight;
        this.maxMovementSpeed = maxMovementSpeed;
        this.maxValueOnLocation = maxValueOnLocation;
        this.maximumSaturation = maximumSaturation;
        this.icon = icon;

    }

    public Double getMaxWeight() {
        return maxWeight;
    }

    public Integer getMovementSpeed() {
        return maxMovementSpeed;
    }

    public Integer getMaxValueOnLocation() {
        return maxValueOnLocation;
    }

    public Double getMaximumSaturation() {
        return maximumSaturation;
    }

    public String getIcon() {
        return icon;
    }
}
