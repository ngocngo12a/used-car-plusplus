package vn.plusplus.used.car.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import vn.plusplus.used.car.interfaces.ParserInterface;
import vn.plusplus.used.car.model.Car;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


//import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.List;

public class CarParser extends ParserInterface<Car> {
    private static List<Car> carModel = new ArrayList<>();
    private static CarService carService=new CarService();

    private Document getHtmlContent(String url) {
        Document pageHtml;
        try {
            Connection.Response response = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.google.com")
                    .followRedirects(true)
                    .timeout(30000)
                    .execute();
            pageHtml = response.parse();
            return pageHtml;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Override
    public Car parserDetail(String url) {
        Document html = getHtmlContent(url);
        Car result = new Car();

        String name = html.select("div.col-md-8.Layout__TopLeft-sc-1lttimv-1.jBVPhX").select("h1.styles__Title-sc-14jh840-1").text();
        String avatar = html.selectFirst("div.styles__ImageWrapper-sc-1r1xial-2.iQyamR").selectFirst("img").attr("alt src");
        String price = html.selectFirst("div.styles__PriceWrapper-sc-14jh840-3.kCmIqn").selectFirst("span.styles__Price-sc-14jh840-4.jBNDPj").ownText();
        String description = html.selectFirst("p.styles__DescriptionAd-sc-14jh840-7.iHuKsX").text();
        String sellerPhone = "";
        String maker = "";
        String year = "";
        String status = "";
        String fuel = "";
        String color = "";
        String design = "";
        String models = "";
        String odo = "";
        String numberOfSeats = "";
        //Lay cac thong tin cua phim
        //Lay het cac phan tu con cua the dl.col
        Elements items = html.select("div.media-body.media-middle");

        for (Element item : items) {
            if (item.selectFirst("span").text().contains("Hãng:")) {
                maker = item.select("span[itemprop='brand']").text();
            }

            if (item.selectFirst("span").text().contains("Năm sản xuất")) {
                year = item.select("span[itemprop='productionDate']").text();
            }
            /*if (items.get(i).ownText().equals("Year of manufacture:")) {
                year = items.get(i + 1).text();
            }
            if (items.get(i).ownText().equals("Status:")) {
                status = items.get(i + 1).text();
            }
            if (items.get(i).ownText().equals("Fuel:")) {
                fuel = items.get(i + 1).text();
            }
            if (items.get(i).ownText().equals("Design:")) {
                models = items.get(i + 1).text();
            }
            if (items.get(i).ownText().equals("Model:")) {
                models = items.get(i + 1).text();
            }
            if (items.get(i).ownText().equals("Km traveled")) {
                odo = items.get(i + 1).text();
            }
            if (items.get(i).ownText().equals("Number of seats:")) {
                numberOfSeats = items.get(i + 1).text();*/
        }

        result.setName(name);
        result.setImage(avatar);
        result.setDescription(description);
        result.setMaker(maker);
        result.setYear(Integer.valueOf(year));
        result.setFuel(fuel);
        result.setModels(models);
        result.setOdo(Integer.valueOf(odo));
        result.setPrice(Float.parseFloat(price));
        result.setNumberOfSeats(Integer.valueOf(numberOfSeats));

        return result;
    }

    @Override
    public List<String> parserListLink(String url) {
        //Parser link chua danh sach cac phim de lay duoc link chi tiet moi phim
        Document html = getHtmlContent(url);
        Elements elements = html.select("div.ctAdlisting").select("ul").select("li");

        List<String> linkArray = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);
            String linkFilm = element.selectFirst("a").attr("href");
            linkArray.add("http://www.xe.chotot.com/" + linkFilm);
        }
        return linkArray;
    }

    public List<Car> parserAllcar(String url) {
        List<Car> carList =new ArrayList<>();
        List<String> linkArray = parserListLink(url);
        for (String link : linkArray) {
            Car carModel = parserDetail(link);// lấy từng thuộc tính trong link
            carList.add(carModel);
        }
        return carList;
    }
}
