public class TaskItem {
    boolean complete = false;
    String title;
    String description;
    String date;

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        if(title.length() > 0){
            this.title = title;
        }else{
            System.err.println("must be at least one character in length");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date){
        if(date.matches("([0-9]{2})-([0-9]{2})-([0-9]{4})")){
            this.date = date;
        }else{
            System.err.println("must be format (YYYY-MM-DD)");
        }
    }
}
