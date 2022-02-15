package applications.apiFramework.apiEngine.pojoclasses.response;

public class TokenResponse {
    private String id;
    private String systemName;
    private String type;
    private String hddCapacity;

    /**
     * No args constructor for use in serialization
     *
     */
    public TokenResponse() {
    }

    /**
     *
     * @param hddCapacity
     * @param systemName
     * @param id
     * @param type
     */
    public TokenResponse(String id, String systemName, String type, String hddCapacity) {
        super();
        this.id = id;
        this.systemName = systemName;
        this.type = type;
        this.hddCapacity = hddCapacity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHddCapacity() {
        return hddCapacity;
    }

    public void setHddCapacity(String hddCapacity) {
        this.hddCapacity = hddCapacity;
    }
}
