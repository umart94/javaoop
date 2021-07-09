package com.umartariq;

public class Main {

    public static void main(String[] args) {
        FootballPlayer tombrady = new FootballPlayer("Tom Brady");
        BaseballPlayer derekjeter = new BaseballPlayer("Derek Sanderson Jeter");
        SoccerPlayer lionelmessi = new SoccerPlayer("Lionel Messi");

        Team<FootballPlayer> newenglandpatriots = new Team<>("New England Patriots");
        newenglandpatriots.addPlayer(tombrady);


        Team<BaseballPlayer> newyorkyankees = new Team<>("New York Yankees");
        newyorkyankees.addPlayer(derekjeter);

        Team<SoccerPlayer> footballclubbarcelona = new Team<>("Football Club Barcelona");
        footballclubbarcelona.addPlayer(lionelmessi);

        Team<SoccerPlayer> dortmund = new Team<>("Dortmund");
        SoccerPlayer matshummels = new SoccerPlayer("Mats Hummels");
        dortmund.addPlayer(matshummels);

        Team<SoccerPlayer> intermilan = new Team<>("Inter Milan");
        SoccerPlayer mauroicardi = new SoccerPlayer("Mauro Icardi");
        intermilan.addPlayer(mauroicardi);

        Team<SoccerPlayer> parissaintgerman = new Team<>("ParisSaintGerman");
        SoccerPlayer cavani = new SoccerPlayer("cavani");
        intermilan.addPlayer(mauroicardi);

        /*Team<String> brokenTeam = new Team<>("this won't work");
        brokenTeam.addPlayer("no-one");
        String cannot be cast to player
*/

        footballclubbarcelona.matchResult(dortmund,3,1);
        footballclubbarcelona.matchResult(intermilan,2,1);
        footballclubbarcelona.matchResult(parissaintgerman,6,1);

        System.out.println("Rankings ");
        System.out.println(footballclubbarcelona.getName() + " : "  +footballclubbarcelona.ranking());
        System.out.println(dortmund.getName() + " : "  +dortmund.ranking());
        System.out.println(parissaintgerman.getName() + " : "  +parissaintgerman.ranking());

        System.out.println(dortmund.compareTo(footballclubbarcelona));
        System.out.println(intermilan.compareTo(footballclubbarcelona));
        System.out.println(footballclubbarcelona.compareTo(intermilan));
        System.out.println(footballclubbarcelona.compareTo(dortmund));

        League<Team<SoccerPlayer>> UCL = new League<>("UCL");
        UCL.add(footballclubbarcelona);
        UCL.add(dortmund);
        UCL.add(intermilan);
        UCL.add(parissaintgerman);

        UCL.showLeagueTable();


    }
}
