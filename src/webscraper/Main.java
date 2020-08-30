package webscraper;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;



public class Main {

	public static void main(String[] args) {
		
		String url = "https://www.araujo.com.br/protetor-solar-neostrata-minesol-oil-control-fps-70-gel-creme-40g/p?idsku=222615";
		
		try {
			Document document = Jsoup.connect(url).get();
			//System.out.println(document.outerHtml());
			
			Element productName = document.selectFirst("h1.product-name");
			System.out.println("Produto: "+productName.text());
			Element productOldPrice = document.selectFirst("em.valor-de");
			System.out.println(productOldPrice.text());
			Element productNewPrice = document.selectFirst("em.valor-por");
			System.out.println(productNewPrice.text());
			Element image = document.select("img").first();
			String urlImg = image.absUrl("src");
			System.out.print("Imagem do produto: "+urlImg);
			
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		
	}

}
