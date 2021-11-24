package Lab05.Character.Job;

public class Job implements JobInterface {

    protected double hp;
    protected double mp;
    protected double atk;
    protected double agi;
    protected double def;
    protected double intel;
    protected String skillName;
    protected JobType jobType;

    public Job(JobType jobType, double hp, double mp, double atk, double def, double agi,double intel){
        this.jobType = jobType;
        this.hp = hp;
        this.mp  = mp;
        this.atk = atk;
        this.def = def;
        this.agi = agi;
        this.intel = intel;

    }

    @Override
    public JobType getJobName() {
        return jobType;
    }

    @Override
    public double getJobAtk() {
        return atk;
    }

    @Override
    public double getJobDef() {
        return def;
    }

    @Override
    public double getJobHp() {
        return hp;
    }

    @Override
    public double getJobMp() {
        return mp;
    }

    @Override
    public double getJobAgi() {
        return agi;
    }

    @Override
    public double getJobIntel() {
        return intel;
    }

    @Override
    public String getJobSkill() {
        return skillName;
    }
}
