package it.eng.moband2017;


public class Giorno {
    private long id;
    private long in_dt_time;
    private long out_dt_time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIn_dt_time() {
        return in_dt_time;
    }

    public void setIn_dt_time(long in_dt_time) {
        this.in_dt_time = in_dt_time;
    }

    public long getOut_dt_time() {
        return out_dt_time;
    }

    public void setOut_dt_time(long out_dt_time) {
        this.out_dt_time = out_dt_time;
    }



    public Giorno()
    {
    }

    public Giorno(long id,
                  long in_dt_time,
                  long out_dt_time
                  )
    {
        this.id=id;
        this.in_dt_time=in_dt_time;
        this.out_dt_time=out_dt_time;
    }
}