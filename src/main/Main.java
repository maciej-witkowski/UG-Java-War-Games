package main;

public class Main {
    public static void main(String[] args) throws Exception {
        General general0 = new General("Maciej", "Witkowski");
        General general1 = new General("Jan", "Wilk");
        Attache attache = new Attache("Jan", "Kowalski", general0, general1);
        general0.attach(attache);
        general1.attach(attache);
        general0.recruit(4, 4);
        general1.recruit(1, 4);
//        general0.recruit(1, 2);
//        general0.recruit(4, 3);
//        general0.recruit(1, 1);
//        general1.recruit(2, 2);
//        general1.recruit(4, 1);
//        general1.recruit(1, 2);
//        general0.info();
//        general0.army();
//        general1.info();
//        general1.army();
//        general0.commandManeuvers();
//        general0.commandManeuvers();
//        general1.commandManeuvers();
//        general1.commandManeuvers();
//        general1.commandManeuvers();
//        general1.commandManeuvers();
//        general0.info();
//        general0.army();
//        general1.info();
//        general1.army();
//        general0.attack(general1);
//        general0.info();
//        general0.army();
//        general1.info();
//        general1.army();
//        general1.attack(general0);
//        general0.info();
//        general0.army();
//        general1.info();
//        general1.army();
//        attache.reportLog();
//        attache.info();
//        RecruitReport report0 = new RecruitReport(general0, 2, 3, 52);
//        ManeuversReport report1 = new ManeuversReport(general0, 82, true);
//        ManeuversReport report2 = new ManeuversReport(general0, 82, true, new String[] {"7408f2bcd043", "28671fe657cd"});
//        AttackReport report3 = new AttackReport(general0, general1, "Wygrana");
//        DefendReport report5 = new DefendReport(general1, general0, "Przegrana");
//        AttackReport report4 = new AttackReport(general0, general1, "Remis", "4c0f6ab64d9a");
//        DefendReport report6 = new DefendReport(general1, general0, "Remis", "0ec9a9e6427e");
//        SoldierPromotionReport report7 = new SoldierPromotionReport(general0, soldier);
//        SoldierDeathReport report8 = new SoldierDeathReport(general0, soldier, "draw");
//        System.out.println(report0.ready());
//        System.out.println(report1.ready());
//        System.out.println(report2.ready());
//        System.out.println(report3.ready());
//        System.out.println(report5.ready());
//        System.out.println(report4.ready());
//        System.out.println(report6.ready());
//        System.out.println(report7.ready());
//        System.out.println(report8.ready());
//        general0.info();
//        general0.army();
//        general1.info();
//        general1.army();
//        general0.save();
//        general1.load("save_");
//        general0.info();
//        general0.army();
//        general1.info();
//        general1.army();
    }
}
