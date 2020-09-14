package com.odenktools.resourceserver.util;

/**
 * @author K.O
 */
public class SuffixBean {
	private String suffix;

	public SuffixBean(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public String toString() {
		return suffix.toLowerCase();
	}

	@Override
	public int hashCode() {
		return suffix.toLowerCase().hashCode();
	}

	@Override
	public boolean equals(Object target) {
		if (target != null && target instanceof SuffixBean) {
			SuffixBean suf = (SuffixBean) target;
			if (this.suffix.equalsIgnoreCase(suf.suffix)) {
				return true;
			} else {
				if (this.suffix.equalsIgnoreCase("jpg") && suf.suffix.equalsIgnoreCase("jpeg")) {
					return true;
				}
				if (this.suffix.equalsIgnoreCase("jpeg") && suf.suffix.equalsIgnoreCase("jpg")) {
					return true;
				}
				return false;
			}
		} else {
			return false;
		}

	}
}
