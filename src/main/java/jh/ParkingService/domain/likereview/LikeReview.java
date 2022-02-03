package jh.ParkingService.domain.likereview;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "LIKE_REVIEW")
public class LikeReview {
    @Id
    @Column(name = "likeId")
    private String likeId;

    @ManyToOne
    @JoinColumn(name = "reviewUid")
    @Column(name = "likeReviewUid")
    private int likeReviewUid;

    @ManyToOne
    @JoinColumn(name = "uid")
    @Column(name = "likeUserUid")
    private String likeUserUid;

    @Column(name = "likeCheck")
    private boolean likeCheck;


    public LikeReview(String likeId, int likeReviewUid, String likeUserUid) {
        this.likeId = likeId;
        this.likeReviewUid = likeReviewUid;
        this.likeUserUid = likeUserUid;
    }
}
