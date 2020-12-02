public class TaskItem {
    String title;
    String description;
    String date;
    boolean complete;

    public TaskItem(String date, String title, String description){
        setDate(date);
        setTitle(title);
        setDescription(description);
    }

    public TaskItem(String date){
        this.date = date;
    }

    public void setDate(String date) throws IllegalArgumentException {
        if(date.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")){
            this.date = date;
        } else {
            throw new IllegalArgumentException("must be format (YYYY-MM-DD)");
        }
    }

    public void setDate1(String date){
        try{
            if(date.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")){
                this.date = date;
            }else{
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException illegalArgumentException) {
            System.err.println("must be format (YYYY-MM-DD)");
        }
    }

    public void setTitle(String title) throws IllegalArgumentException {
        if(title.length() >= 1){
            this.title = title;
        } else {
            throw new IllegalArgumentException("must be at least one character in length");
        }
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setComplete(boolean complete) { this.complete = complete; }
}
