package kitchenpos.application;

import java.util.List;
import java.util.stream.Collectors;
import kitchenpos.domain.menu.MenuGroup;
import kitchenpos.dto.menugroup.MenuGroupRequest;
import kitchenpos.dto.menugroup.MenuGroupResponse;
import kitchenpos.repository.MenuGroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class MenuGroupService {

    private final MenuGroupRepository menuGroupRepository;

    public MenuGroupService(final MenuGroupRepository menuGroupRepository) {
        this.menuGroupRepository = menuGroupRepository;
    }

    @Transactional
    public MenuGroupResponse create(final MenuGroupRequest menuGroupRequest) {
        final MenuGroup menuGroup = new MenuGroup(menuGroupRequest.getName());
        menuGroupRepository.save(menuGroup);
        return new MenuGroupResponse(menuGroup);
    }

    public List<MenuGroupResponse> list() {
        final List<MenuGroup> menuGroups = menuGroupRepository.findAll();
        return menuGroups.stream()
            .map(MenuGroupResponse::new)
            .collect(Collectors.toUnmodifiableList());
    }
}
