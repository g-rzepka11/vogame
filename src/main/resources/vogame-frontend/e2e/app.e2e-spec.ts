import { VogameFrontendPage } from './app.po';

describe('vogame-frontend App', function() {
  let page: VogameFrontendPage;

  beforeEach(() => {
    page = new VogameFrontendPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
