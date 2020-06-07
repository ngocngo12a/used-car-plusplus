package vn.plusplus.used.car.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import vn.plusplus.used.car.interfaces.ParserInterface;
import vn.plusplus.used.car.model.Car;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.List;

public class CarParser extends ParserInterface <Car>{
    private static List<String> linkArray=new ArrayList<>();
    private static List<Car> carModel=new ArrayList<>();
    private static ParserInterface carParser=new ParserInterface();
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
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Override
    public Car parserDetail(String url) {
        Document html= getHtmlContent(url);
        Car result=new Car();

        String name=html.selectFirst("div.col-md-8 Layout__TopLeft-sc-1lttimv-1 jBVPhX").selectFirst("div.styles__Wrapper-sc-1r1xial-0 fsRMgu").text()
        String avatar=html.selectFirst("div.styles__ImageWrapper-sc-1r1xial-2 iQyamR").selectFirst("img").attr("alt src");
        String price = html.selectFirst("div.styles__PriceWrapper-sc-14jh840-3 kCmIqn").selectFirst("span.styles__Price-sc-14jh840-4 jBNDPj").ownText();
        String description=html.selectFirst("div.d-lg-none d-block col-xs-12 no-padding profileMobile___3crSz ContactPanel__Wrapper-w7ybi6-0 icVeqT").selectFirst("p").text();
        String sellerPhone="";
        String maker="";
        String year="";
        String status="";
        String fuel="";
        String color="";
        String design="";
        String models="";
        String odo="";
        String numberOfSeats="";
        //Lay cac thong tin cua phim
        Element pros = pros =html.selectFirst("dl.media-body media-middle");
        //Lay het cac phan tu con cua the dl.col
        Elements child = pros.children();
        for (int i = 0; i <child.size() ; i++) {
            if(child.get(i).ownText().equals("Brand:")){
                maker = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Year of manufacture:")){
                year = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Status:")){
                status = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Fuel:")){
                fuel = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Design:")){
                models = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Model:")){
                models = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Km traveled")){
                odo = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Number of seats:")){
                numberOfSeats = child.get(i+1).text();
            }

            result.setName(name);
            result.setImage(avatar);
            result.setDescription(description);
            result.setFuel(fuel);
            result.setMaker(maker);
            result.setModels(models);
            result.setOdo(odo);
            result.setPrice(price);
            result.getNumberOfSeats(numberOfSeats);

        }

       return null;
    }

    @Override
    public List<String> parserListLink(String url) {
        //Parser link chua danh sach cac phim de lay duoc link chi tiet moi phim
        Document html =getHtmlContent(url);
        Elements elements = html.selectFirst("div.ctAdlisting").select("ul").select("li");

        List<String> linkArray = new ArrayList<>();

        for(int i=0; i < elements.size(); i ++){
            Element element = elements.get(i);
            String linkFilm = element.selectFirst("a").attr("href");
            linkArray.add("http://www.xe.chotot.com/" + linkFilm);
        }
        return linkArray;
    }
    public void parserAllcar(){
        for (int i = 1; i <1 ; i++) {
            String url = "https://xe.chotot.com/toan-quoc/mua-ban-oto?page="+i;
            linkArray = carParser.parserListLink(url);
            for (String link : linkArray) {
                Car carModel = carParser.parserDetail(link);// lấy từng thuộc tính trong link
            }
        }
    }

}
