package site.dittotrip.ditto_trip.reward.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import site.dittotrip.ditto_trip.reward.domain.enums.ItemType;
import site.dittotrip.ditto_trip.reward.domain.enums.RewardType;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Item extends Reward {

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    public Item(String name, String imagePath, ItemType itemType) {
        super(name, imagePath, RewardType.ITEM);
        this.itemType = itemType;
    }

}
