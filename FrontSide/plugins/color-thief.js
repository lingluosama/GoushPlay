// plugins/color-thief.js
import ColorThief from 'color-thief';

export default (context, inject) => {
    inject('colorThief', new ColorThief());
};
