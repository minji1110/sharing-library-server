package minji.sharinglibraryserver.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseTime {
    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(insertable = false)
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
