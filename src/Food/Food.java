
package Food;

import Tools.Utils;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Food implements Comparable<Food> {

    protected String name;
    protected String id;
    protected double weight;
    protected String type;
    protected String place;
    protected Date expiredDate;

    public Food() {
    }

    public Food(String name, String id, double weight, String type, String place, Date expiredDate) {
        this.name = name;
        this.id = id;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expiredDate = expiredDate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public void create() {
        id = Utils.getString("ID: ", "Try Again!");
        name = Utils.getString("Name: ", "Try Again!");
        weight = Utils.getDouble("Weight: ", "Try Again!");
        type = Utils.getString("Type: ", "Try Again");
        place = Utils.getString("Place: ", "Try Again");
        expiredDate = Utils.getDate();
    }


    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return "Food{" + "name= " + name + "   |id= " + id + "   |weight= " + weight + "   |type= " + type + "   |place= " + place + "   |expiredDate= " + df.format(expiredDate) + '}';
    }

    @Override
    public int compareTo(Food o) {
        if (getExpiredDate() == null || o.getExpiredDate() == null) {
            return 0;
        }
        return getExpiredDate().compareTo(o.getExpiredDate());
    }
    
    
}
