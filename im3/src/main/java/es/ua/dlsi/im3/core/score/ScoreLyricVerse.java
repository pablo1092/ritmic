/*
 * Copyright (C) 2014 David Rizo Valero
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package es.ua.dlsi.im3.core.score;

import java.util.Objects;

import es.ua.dlsi.im3.adt.IIndexed;

/**
 * @author drizo
 */
public class ScoreLyricVerse implements IIndexed {
	int number;
	Staff staff;

	public ScoreLyricVerse(int number, Staff staff) {
		this.number = number;
		this.staff = staff;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ScoreLyricVerse other = (ScoreLyricVerse) obj;
		if (this.number != other.number) {
			return false;
		}
		if (!Objects.equals(this.staff, other.staff)) {
			return false;
		}
		return true;
	}

	@Override
	public int getIndex() {
		return number;
	}

	@Override
	public int compareTo(IIndexed oo) {
		ScoreLyricVerse o = (ScoreLyricVerse) oo;
		if (this.staff != o.staff) {
			return this.staff.compareTo(o.staff);
		} else {
			return this.number - o.number;
		}
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

}
