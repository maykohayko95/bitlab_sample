package BigProjectAvia;

import javax.swing.*;

public class MainFrame extends JFrame {
    private MainMenu mainMenuPage;
    private AddAircrafts addAircraftsPage;
    private ListAircrafts listAircraftsPage;
    private AddCities addCityPage;
    private ListCities listCitiesPage;
    private AddFlights addFlightPage;
    private ListFlights listFlightsPage;
    private AddTickets addTicketPage;
    private ListTickets listTicketsPage;

        public MainFrame() {

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("AIRLINE APPLICATION");
            setSize(1000, 1000);
            setLayout(null);

            mainMenuPage = new MainMenu(this);
            mainMenuPage.setVisible(true);
            add(mainMenuPage);

            addAircraftsPage = new AddAircrafts(this);
            addAircraftsPage.setVisible(false);
            add(addAircraftsPage);

            listAircraftsPage = new ListAircrafts(this);
            listAircraftsPage.setVisible(false);
            add(listAircraftsPage);

            addCityPage = new AddCities(this);
            addCityPage.setVisible(false);
            add(addCityPage);

            listCitiesPage = new ListCities(this);
            listCitiesPage.setVisible(false);
            add(listCitiesPage);

            addFlightPage = new AddFlights(this);
            addFlightPage.setVisible(false);
            add(addFlightPage);

            listFlightsPage = new ListFlights(this);
            listFlightsPage.setVisible(false);
            add(listFlightsPage);

            addTicketPage = new AddTickets(this);
            addTicketPage.setVisible(false);
            add(addTicketPage);

            listTicketsPage = new ListTickets(this);
            listTicketsPage.setVisible(false);
            add(listTicketsPage);
        }

        public MainMenu getMainMenuPage() {
            return mainMenuPage;
        }

        public AddAircrafts getAddAircraftsPage() {
            return addAircraftsPage;
        }

        public ListAircrafts getListAircraftsPage() {
            return listAircraftsPage;
        }
        public AddCities getAddCityPage() {
        return addCityPage;
    }

        public ListCities getListCitiesPage() {
        return listCitiesPage;
    }

        public AddFlights getAddFlightPage() {
        return addFlightPage;
    }

        public ListFlights getListFlightsPage() {
        return listFlightsPage;
    }

        public AddTickets getAddTicketPage() {
        return addTicketPage;
    }

        public ListTickets getListTicketsPage() {
        return listTicketsPage;
    }

    }
