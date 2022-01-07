package me.zhangjin.bank.repository;

import javax.validation.constraints.NotNull;

public interface Repository<T extends Aggregate<ID>, ID extends Identifier> {

    /**
     * 将一个 Aggregate 附属到一个 Repository，让它变为可追踪
     * Change-Tracking 在下文会讲，非必须
     */
    void attach(@NotNull T aggregate);

    /**
     * 解除一个 Aggregate 的追踪
     * Change-Tracking 在下文会讲，非必须
     */
    void detach(@NotNull T aggregate);

    /**
     * 通过 ID寻找 Aggregate
     * 找到的 Aggregate 自动是可追踪的
     */
    T find(@NotNull ID id);

    /**
     * 将一个 Aggregate 从 Repository 移除
     * 操作后的aggregate对象自动取消追踪
     */
    void remove(@NotNull T aggregate);

    /**
     * 保存一个 Aggregate
     * 保存后自动重置追踪条件
     */
    void save(@NotNull T aggregate);
}
