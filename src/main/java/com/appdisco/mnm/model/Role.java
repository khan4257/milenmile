/**
 * Project		: MileNMile
 * FileName		: Role.java
 * Package		: com.appdisco.mnm.model
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 6. 오후 1:19:27
 */
package com.appdisco.mnm.model;


/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.Role
 * @file	: Role.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 6. 오후 1:19:27
 * </PRE>
 */
public class Role extends BaseModel<Integer> {

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 2352809708066161437L;

	private String name;
	
	private String description;
	
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name Set to name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description Set to description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Role)) {
            return false;
        }

        final Role role = (Role) o;

        return !(name != null ? !name.equals(role.name) : role.name != null);
    }

    @Override
    public int hashCode() {
        return (name != null ? name.hashCode() : 0);
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(this.name).toString();
//    }
}
