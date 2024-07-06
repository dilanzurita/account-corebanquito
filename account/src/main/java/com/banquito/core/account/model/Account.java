package com.banquito.core.account.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID")
    private Long id;

    @Column(name = "CODE_PRODUCT_TYPE", length = 20, nullable = false)
    private String codeProductType;

    @Column(name = "CODE_PRODUCT", length = 30, nullable = false)
    private String codeProduct;

    @Column(name = "CLIENT_ID", nullable = false)
    private Long clientId;

    @Column(name = "CODE_UNIQUE_ACCOUNT", length = 32, nullable = false)
    private String codeUniqueAccount;

    @Column(name = "CODE_INTERNAL_ACCOUNT", length = 10, nullable = false)
    private String codeInternalAccount;

    @Column(name = "CODE_INTERNATIONAL_ACCOUNT", length = 16, nullable = false)
    private String codeInternationalAccount;

    @Column(name = "STATUS", length = 3, nullable = false)
    private String status;

    @Column(name = "CREATION_DATE", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "ACTIVATION_DATE")
    private LocalDateTime activationDate;

    @Column(name = "LAST_MODIFIED_DATE")
    private LocalDateTime lastModifiedDate;

    @Column(name = "CURRENT_BALANCE", precision = 17, scale = 2, nullable = false)
    private BigDecimal currentBalance;

    @Column(name = "AVAILABLE_BALANCE", precision = 17, scale = 2, nullable = false)
    private BigDecimal availableBalance;

    @Column(name = "BLOCKED_BALANCE", precision = 17, scale = 2, nullable = false)
    private BigDecimal blockedBalance;

    @Column(name = "CLOSED_DATE")
    private LocalDateTime closedDate;

    @OneToMany(mappedBy = "account")
    private List<DebitCard> debitCards;

    @OneToMany(mappedBy = "account")
    private List<AccountInterestAccrued> accountInterestAccrued;

    public Account(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}