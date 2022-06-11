import data.Student;
import manager.StudentList;
import manager.TranscriptList;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class QuoteList {
    private LinkedList<String> quotes = new LinkedList<>();

    public QuoteList init() {
        quotes.add("Thật ra quên không phải là cái đau khổ nhất, người đau khổ là người có trí nhớ.");
        quotes.add("Khi yêu, tưởng rằng người đó là cả cuộc đời mình, ai ngờ vừa tỉnh giấc mộng, đã đứng bên cạnh một người khác.");
        quotes.add("Chờ đợi vốn không phải là điều đáng sợ, điều đáng sợ là không biết phải chờ đợi đến bao giờ…");
        quotes.add("Người ta vô tình vẽ hoa, vẽ lá.\n" + "Tôi đa tình tưởng đấy là mùa xuân");
        quotes.add("Đem lòng yêu một người, có thể là chuyện diễn ra trong tích tắc. Hận một người lại là suốt một đời.");
        quotes.add("Hoá ra, cô đơn không phải vì mình không có người ở bên mà vì người ở bên mình đâu phải người trong lòng mình.");
        quotes.add("Yêu đương một thời, giờ hóa thành tro bụi.");
        quotes.add("Lúc còn trẻ chúng ta từ bỏ, cho rằng đó chỉ là một cuộc tình, nhưng cuối cùng mới biết, đó thực ra là cả cuộc đời.");
        quotes.add("Buông tay - không phải vì không yêu... Mà vì phát hiện bản thân trở thành chướng ngại hạnh phúc của người kia");
        return this;
    }

    public LinkedList<String> getQuotes() {
        return quotes;
    }

    public void setQuotes(LinkedList<String> quotes) {
        this.quotes = quotes;
    }
}
