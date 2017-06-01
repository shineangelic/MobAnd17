package it.eng.moband2017;


public class Giorno {
    private int id;
    private int in_dt_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIn_dt_time() {
        return in_dt_time;
    }

    public void setIn_dt_time(int in_dt_time) {
        this.in_dt_time = in_dt_time;
    }

    public int getOut_dt_time() {
        return out_dt_time;
    }

    public void setOut_dt_time(int out_dt_time) {
        this.out_dt_time = out_dt_time;
    }

    private int out_dt_time;

    public Giorno()
    {
    }

    public Giorno(int id,
                  int in_dt_time,
                  int out_dt_time
                  )
    {
        this.id=id;
        this.in_dt_time=in_dt_time;
        this.out_dt_time=out_dt_time;
    }
}