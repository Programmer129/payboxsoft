export class Utils {

  /**
   * Coverts GEL to Georgian Tetri
   */
  static toSmallerUnit(gel: string): number {
    gel = (gel + '').replace(/[^\d.-]/g, '');
    if (gel && gel.includes('.')) {
      gel = gel.substring(0, gel.indexOf('.') + 3);
    }

    return gel ? Math.round(parseFloat(gel) * 100) : 0;
  }

  /**
   * Converts Georgian Tetri to GEL
   */
  static toGeorgianLari(value: string) {
    value = (value + '').replace(/[^\d.-]/g, '');
    const gel = parseFloat(value);
    return gel ? gel / 100 : 0;
  }
}
