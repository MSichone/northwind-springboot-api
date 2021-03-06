package com.masgotcode.northwind.purchase;

import com.masgotcode.northwind.employee.Employee;
import com.masgotcode.northwind.supplier.Supplier;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "PurchaseOrder")
@Table(name = "purchase_orders")
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name="created_by")
    private Employee createdBy;
    @Column
    private LocalDateTime submittedDate;
    @CreationTimestamp
    private LocalDateTime creationDate;
    @ManyToOne
    private PurchaseOrderStatus status;
    @Column
    private LocalDateTime expectedDate;
    @Column
    private double shippingFee;
    @Column
    private double taxes;
    @Column
    private LocalDateTime paymentDate;
    @Column
    private double paymentAmount;
    @Column
    private String paymentMethod;
    @Column
    private String notes;
    @Column
    private Long approvedBy;
    @Column
    private LocalDateTime approvedDate;
    @Column
    private Long submittedBy;

    @OneToMany(
            mappedBy = "purchaseOrder",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @OrderColumn(name = "position") // Added to fix  Fix org.hibernate.loader.MultipleBagFetchException
    List<PurchaseOrderDetail> purchaseOrderDetails = new ArrayList<>();

    public void addOrderDetail(PurchaseOrderDetail orderDetail){
        purchaseOrderDetails.add(orderDetail);
        orderDetail.setPurchaseOrder(this);
    }

    /*
    @Entity
public class Parent {
    @OneToMany
    @OrderColumn(name="order")
    @JoinColumn(name="parent_id", nullable=false)
    private List<Child> children;
    ...
}

@Entity
public class Child {
    ...
    @ManyToOne
    @JoinColumn(name="parent_id", insertable=false, updatable=false, nullable=false)
    private Parent parent;
    ...
}
     */

}
