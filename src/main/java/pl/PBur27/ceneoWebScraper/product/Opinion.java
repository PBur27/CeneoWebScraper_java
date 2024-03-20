package pl.PBur27.ceneoWebScraper.product;

import java.util.ArrayList;

public class Opinion {
    private String opinion;
    private String opinionId;
    private String author;
    private boolean recommendation;
    private int score;
    private boolean purchased;
    private int[] published_at = new int[3];
    private int[] purchased_at = new int[3];
    private int thumbs_up;
    private int thumbs_down;
    private String content;
    private ArrayList<String> pros = new ArrayList<String>();
    private ArrayList<String> cons = new ArrayList<String>();

    public Opinion() {
    }

    public Opinion(String opinion,
                   String opinionId,
                   String author,
                   boolean recommendation,
                   int score,
                   boolean purchased,
                   int[] published_at,
                   int[] purchased_at,
                   int thumbs_up,
                   int thumbs_down,
                   String content,
                   ArrayList<String> pros,
                   ArrayList<String> cons) {
        this.opinion = opinion;
        this.opinionId = opinionId;
        this.author = author;
        this.recommendation = recommendation;
        this.score = score;
        this.purchased = purchased;
        this.published_at = published_at;
        this.purchased_at = purchased_at;
        this.thumbs_up = thumbs_up;
        this.thumbs_down = thumbs_down;
        this.content = content;
        this.pros = pros;
        this.cons = cons;
    }
}
