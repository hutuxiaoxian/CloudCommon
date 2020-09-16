package com.zhishouwei.common.model;

import lombok.Data;

import java.util.List;
@Data
public class MatchRule {
    private String col;
    private String rule;
    private String val;
    private List<String> values;

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof MatchRule)) {
            return false;
        } else {
            MatchRule other = (MatchRule)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$col = this.getCol();
                    Object other$col = other.getCol();
                    if (this$col == null) {
                        if (other$col == null) {
                            break label59;
                        }
                    } else if (this$col.equals(other$col)) {
                        break label59;
                    }

                    return false;
                }

                Object this$rule = this.getRule();
                Object other$rule = other.getRule();
                if (this$rule == null) {
                    if (other$rule != null) {
                        return false;
                    }
                } else if (!this$rule.equals(other$rule)) {
                    return false;
                }

                Object this$val = this.getVal();
                Object other$val = other.getVal();
                if (this$val == null) {
                    if (other$val != null) {
                        return false;
                    }
                } else if (!this$val.equals(other$val)) {
                    return false;
                }

                Object this$values = this.getValues();
                Object other$values = other.getValues();
                if (this$values == null) {
                    if (other$values != null) {
                        return false;
                    }
                } else if (!this$values.equals(other$values)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof MatchRule;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $col = this.getCol();
        result = result * 59 + ($col == null ? 43 : $col.hashCode());
        Object $rule = this.getRule();
        result = result * 59 + ($rule == null ? 43 : $rule.hashCode());
        Object $val = this.getVal();
        result = result * 59 + ($val == null ? 43 : $val.hashCode());
        Object $values = this.getValues();
        result = result * 59 + ($values == null ? 43 : $values.hashCode());
        return result;
    }
}
