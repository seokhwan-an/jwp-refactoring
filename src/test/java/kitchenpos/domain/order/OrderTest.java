package kitchenpos.domain.order;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {

    @DisplayName("OrderStatus의 상태를 변경한다.")
    @Test
    void change_order_Status() {
        // given
        final Order order = new Order(1L, new OrderLineItems());
        String changingStatus = OrderStatus.COMPLETION.name();

        // when
        order.changeStatus(changingStatus);

        // then
        assertThat(order.getOrderStatus()).isEqualTo(changingStatus);
    }

    @DisplayName("현재 OrderStatus의 상태가 Completion이면 예외를 발생한다.")
    @Test
    void change_status_fail() {
        // given
        final Order completionOrder = new Order(1L, 1L, OrderStatus.COMPLETION, new OrderLineItems());
        String changingStatus = OrderStatus.COOKING.name();

        // when
        // then
        assertThatThrownBy(() -> completionOrder.changeStatus(changingStatus))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이미 Completion인 상태인 경우 주문 테이블의 상태를 변경할 수 없습니다.");
    }

    @DisplayName("주문에 주문상품을 추가하면 연관관계가 맺어진다.")
    @Test
    void add_orderLineItem() {
        // given
        final OrderLineItem orderLineItem = new OrderLineItem(1L, 2);

        // when
        final Order order = new Order(2L, new OrderLineItems(List.of(orderLineItem)));

        // then
        assertThat(orderLineItem.getOrder()).isEqualTo(order);
    }
}
