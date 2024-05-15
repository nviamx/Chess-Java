
public class Knight implements ChessPiece {
	private Position p;

	public Knight(Position p) {
		if (p == null) {
			throw new NullPointerException("Position is null");
		} else if ((p.getCol() <= 8 && p.getCol() > 0) && (p.getRow() <= 8 && p.getRow() > 0)) {
			this.p = new Position(p.getRow(), p.getCol());
		} else {
			this.p = null;
			throw new NullPointerException("Position is invalid");
		}
	}

	private Position RigthUp(int col, int row) {
		col += 2;
		row -= 1;
		if (col > 8 || row <= 0)
			return null;
		return new Position(row, col);
	}

	private Position RigthDown(int col, int row) {
		col += 2;
		row += 1;
		if (col > 8 || row > 8)
			return null;
		return new Position(row, col);
	}

	private Position LiftUp(int col, int row) {
		col -= 2;
		row -= 1;
		if (col <= 0 || row <= 0)
			return null;
		return new Position(row, col);
	}

	private Position LiftDown(int col, int row) {
		col -= 2;
		row += 1;
		if (col <= 0 || row > 8)
			return null;
		return new Position(row, col);
	}

	private Position UpRight(int col, int row) {
		col += 1;
		row -= 2;
		if (col > 8 || row <= 0)
			return null;
		return new Position(row, col);
	}

	private Position UpLift(int col, int row) {
		col -= 1;
		row -= 2;
		if (col <= 0 || row <= 0)
			return null;
		return new Position(row, col);
	}

	private Position DownRight(int col, int row) {
		col += 1;
		row += 2;
		if (col > 8 || row > 8)
			return null;
		return new Position(row, col);
	}

	private Position DownLift(int col, int row) {
		col -= 1;
		row += 2;
		if (col <= 0 || row > 8)
			return null;
		return new Position(row, col);
	}

	@Override
	public Position[] moves(Position p) {
		if (p.getRow() != this.p.getRow() || p.getCol() != this.p.getCol())
			return new Position[0];
		int size = 0;
		if (RigthUp(p.getCol(), p.getRow()) != null)
			size++;
		if (RigthDown(p.getCol(), p.getRow()) != null)
			size++;
		if (LiftUp(p.getCol(), p.getRow()) != null)
			size++;
		if (LiftDown(p.getCol(), p.getRow()) != null)
			size++;
		if (UpRight(p.getCol(), p.getRow()) != null)
			size++;
		if (UpLift(p.getCol(), p.getRow()) != null)
			size++;
		if (DownRight(p.getCol(), p.getRow()) != null)
			size++;
		if (DownLift(p.getCol(), p.getRow()) != null)
			size++;
		Position new_p[] = new Position[size];
		size = 0;
		if (RigthUp(p.getCol(), p.getRow()) != null) {
			new_p[size] = RigthUp(p.getCol(), p.getRow());
			size++;
		}
		if (RigthDown(p.getCol(), p.getRow()) != null) {
			new_p[size] = RigthDown(p.getCol(), p.getRow());
			size++;
		}
		if (LiftUp(p.getCol(), p.getRow()) != null) {
			new_p[size] = LiftUp(p.getCol(), p.getRow());
			size++;
		}
		if (LiftDown(p.getCol(), p.getRow()) != null) {
			new_p[size] = LiftDown(p.getCol(), p.getRow());
			size++;
		}
		if (UpRight(p.getCol(), p.getRow()) != null) {
			new_p[size] = UpRight(p.getCol(), p.getRow());
			size++;
		}
		if (UpLift(p.getCol(), p.getRow()) != null) {
			new_p[size] = UpLift(p.getCol(), p.getRow());
			size++;
		}
		if (DownRight(p.getCol(), p.getRow()) != null) {
			new_p[size] = DownRight(p.getCol(), p.getRow());
			size++;
		}
		if (DownLift(p.getCol(), p.getRow()) != null) {
			new_p[size] = DownLift(p.getCol(), p.getRow());
			size++;
		}
		return new_p;
	}

	@Override
	public Position getPosition() {
		return new Position(this.p.getRow(), this.p.getCol());
	}

	public String toString() {
		return "Knight at (" + this.p.getRow() + ", " + this.p.getCol() + ")";
	}
}
